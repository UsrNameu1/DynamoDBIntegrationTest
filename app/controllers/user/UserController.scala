package controllers.user

import javax.inject.Inject
import domain.User
import infrastructure.dbclients.UserDBClient
import play.api.mvc.{BodyParsers, Action, Controller}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.Function.const

/**
 * controller for user endpoint
 * @param dbClient user db client
 */
class UserController @Inject() (dbClient: UserDBClient) extends Controller {

  import RequestConverter._

  /**
   * action for creating user
   * @return
   */
  def post = Action.async(BodyParsers.parse.json) { req =>
    req.body.validate[User].fold(
      invalid => Future(BadRequest),
      user => dbClient.createIfNotExist(user).map(const(Ok))
    )
  }
}

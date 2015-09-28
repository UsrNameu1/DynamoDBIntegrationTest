package modules

import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.google.inject.AbstractModule
import controllers.user.UserController
import infrastructure.dbclients.{UserDBClient, DynamoDBProvider}

/**
 * resolves DI
 */
class AppDependencyModule extends AbstractModule {

  def configure() = {
    bind(classOf[DynamoDB]).toProvider(classOf[DynamoDBProvider])
  }
}

package infrastructure.dbclients

import java.util.concurrent.Executors

import scala.concurrent.ExecutionContext

/**
 * concurrent execution context for dynamodb
 */
object DynamoDBExecutionContext {

  implicit lazy val context = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(1))

}

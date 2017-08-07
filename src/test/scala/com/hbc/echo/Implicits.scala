package com.hbc.echo

import scala.concurrent.{Future, Promise}
import scalaz.concurrent.Task

import io.circe.{Encoder, Decoder}

object Implicits {
  implicit class TaskOps[T](val t: Task[T]) extends AnyVal {
    def asFuture: Future[T] = taskToFuture(t)
  }

  implicit def taskToFuture[T](task: Task[T]): Future[T] = {
    val promise: Promise[T] = Promise()
    task.unsafePerformAsync {
      case scalaz.-\/(ex) =>
        promise.failure(ex);
      case scalaz.\/-(r) => promise.success(r);
    }
    promise.future
  }
  implicit def circeJsonDecoder[A](implicit decoder: Decoder[A]) = org.http4s.circe.jsonOf[A]
  implicit def circeJsonEncoder[A](implicit encoder: Encoder[A]) = org.http4s.circe.jsonEncoderOf[A]

}

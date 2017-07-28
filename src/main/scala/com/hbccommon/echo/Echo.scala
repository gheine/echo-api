package com.hbccommon.echo

import io.circe._
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl._

object Echo {
  val service = HttpService {
    case GET -> Root / "echo" / message =>
      Ok(Json.obj("message" -> Json.fromString(s"$message")))
  }
}

package com.hbccommon.echo

import com.hbccommon.echo.api.v0.echo
import io.circe.{Decoder, Encoder}
import org.http4s.{EntityDecoder, EntityEncoder, HttpService}
import io.circe.generic.auto._
import org.http4s.dsl._

object Service {
  implicit def circeJsonDecoder[A](implicit decoder: Decoder[A]): EntityDecoder[A] = org.http4s.circe.jsonOf[A]
  implicit def circeJsonEncoder[A](implicit encoder: Encoder[A]): EntityEncoder[A] = org.http4s.circe.jsonEncoderOf[A]

  val service = HttpService {
    case GET -> Root / "echo" / message => Ok(echo(message.toString))
  }
}

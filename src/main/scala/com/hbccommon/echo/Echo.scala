package com.hbccommon.echo

import io.circe._
import org.http4s.client.blaze.PooledHttp1Client
import org.http4s.{MediaType, HttpService}
import org.http4s.headers.`Content-Type`
import org.http4s.dsl._
import scodec.bits.ByteVector

object Echo {
  val client = PooledHttp1Client()
  val service = HttpService {
    case GET -> Root / "echo" / message => {
      System.out.println(Json.obj("message" -> Json.fromString(s"$message")))
      // Ok(Json.obj("message" -> Json.fromString(s"$message")))
      Ok(client.expect[ByteVector]("http://live.echo-api-master.stqa.s5a.hbccommon.private.hbc.com" + Json.obj("message" -> Json.fromString(s"$message"))))
        .withContentType(Some(`Content-Type`(MediaType.`application/json`)))
        .handleWith { case _ => GatewayTimeout() }
    }
  }
}

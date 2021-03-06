/**
 * Generated by API Builder - https://www.apibuilder.io
 * Service version: 0.2.2
 * apibuilder:0.12.61 https://app.apibuilder.io/hbc/echo-api/0.2.2/http4s_0_15
 */
package com.hbc.echo.api.v0.models {

  /**
   * The echo
   * 
   * @param message Something to be echoed....
   */
  case class Echo(
    message: String
  )

}

package com.hbc.echo.api.v0.models {

  package object json {
    import scala.util.Try
    import io.circe.{Json, JsonObject, Encoder, Decoder, DecodingFailure}
    import io.circe.syntax._
    import com.hbc.echo.api.v0.models.json._

    // Make Scala 2.11 Either monadic
    private[v0] implicit def eitherOps[A,B](e: Either[A,B]) = cats.implicits.catsSyntaxEither(e)

    private[v0] implicit val decodeUUID: Decoder[_root_.java.util.UUID] =
      Decoder.decodeString.emapTry(str => Try(_root_.java.util.UUID.fromString(str)))

    private[v0] implicit val encodeUUID: Encoder[_root_.java.util.UUID] =
      Encoder.encodeString.contramap[_root_.java.util.UUID](_.toString)

    private[v0] implicit val decodeInstant: Decoder[_root_.java.time.Instant] =
      Decoder.decodeString.emapTry(str => Try(_root_.java.time.Instant.parse(str)))

    private[v0] implicit val encodeInstant: Encoder[_root_.java.time.Instant] =
      Encoder.encodeString.contramap[_root_.java.time.Instant](_.toString)

    private[v0] implicit val decodeLocalDate: Decoder[_root_.java.time.LocalDate] =
      Decoder.decodeString.emapTry(str => Try(_root_.java.time.LocalDate.parse(str)))

    private[v0] implicit val encodeLocalDate: Encoder[_root_.java.time.LocalDate] =
      Encoder.encodeString.contramap[_root_.java.time.LocalDate](_.toString)

    implicit def decodeEchoApiEcho: Decoder[Echo] = Decoder.instance { c =>
     for {
        message <- c.downField("message").as[String]
      } yield {
        Echo(
          message = message
        )
      }
    }

    implicit def encodeEchoApiEcho: Encoder[Echo] = Encoder.instance { t =>
      Json.fromFields(Seq(
        Some("message" -> t.message.asJson)
      ).flatten)
    }
  }
}

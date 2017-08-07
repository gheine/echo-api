package com.hbc.echo

import Implicits._
import com.hbc.echo.api.v0.Client
import org.scalatest.{AsyncFunSpec, Matchers}


import scala.util.Random

class EchoApi extends AsyncFunSpec with Matchers {

  val baseUrl = "http://localhost:8080"
  val client = new Client(baseUrl = org.http4s.Uri.unsafeFromString(baseUrl))

  val rndChars: Iterator[Char] = {
    def randomChar: Char = {
      val c = Random.nextPrintableChar()
      if (c.isLetterOrDigit) c else randomChar
    }

    Iterator.continually(randomChar)
  }

  def randomString(minLen: Int = 12, maxLen: Int = 18): String = {
    val len = minLen + Random.nextInt(maxLen - minLen + 1)
    rndChars.take(len).mkString
  }

  describe("Api")(it("should echo what is sent") {
    val message = randomString()
    for {response <- client.echoes.get(message) } yield {
      response.map(_.message).get shouldBe message
    }
  })
}


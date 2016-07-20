package com.example

/**
  * Created by Akshay Harale<akshay.harale@synerzip.com/> on 15/7/16.
  */

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class GatlingTest extends Simulation {

  val conf = http.baseURL("http://localhost:9000")


  val scn = scenario("TestCount")
      .repeat(100000,"n"){
      exec(http("count").get("/count"))
    }



  setUp(scn.inject(atOnceUsers(5)))
    .protocols(conf)
}

import twitter4j._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.JavaConverters._
import scala.concurrent.Future

object Operations {

    // (1) config work to create a twitter object

   // val twitter = TwitterConnectionFactory.getInstance(consumerKey, consumerSecret, accessToken, accessTokenSecret)

    /*
        val statuses = twitter.getHomeTimeline()
        print(statuses)
    */
    def printTweets(twitter: Twitter,trend: String): Future[List[Status]] = Future {
      val query: Query = new Query(trend)
      val result: QueryResult = twitter.search(query)
      result.getTweets.asScala.toList // call thread.sleep in main
    }

  /*  val queryTrend: String = "#knoldus"
    val query: Query = new Query(queryTrend)
  */  //    val setDate = new SimpleDateFormat("")
    /*
        val sdf = new SimpleDateFormat("yyyy-mm-dd")
        val customDate = sdf.parse("2018-01-01")
        val cusDate = sdf.format(customDate)
    */

    //  val modifiedDate = new SimpleDateFormat("yyyymmdd").parse("20  18-01-21")//format(Calendar.getInstance().getTime)
    //   println(modifiedDate)
    //   query.setSince(modifiedDate)
    /*   query.setCount(10000)
       query.setSince("2018-01-21")
     val result: QueryResult = twitter.search(query)

    val tweets = result.getTweets.asScala.toList
    print(tweets.map(x => s"${x.getText} \n"))*/
    // println(s"created at : ${twitter.showUser
  // (queryTrend).getCreatedAt}")

    def getTweetCount(twitter: Twitter,trend: String): Future[Int] = Future {
      val query: Query = new Query(trend)
      val count = 100
      query.setSince("2018-01-21")
      query.setCount(count)
      query.setUntil("2018-01-31")
      val result: QueryResult = twitter.search(query)
      val tweets = result.getTweets.asScala.toList
      tweets.length
    }

    def averageTweets(twitter: Twitter,trend: String): Future[Float] = Future {
      val count = getTweetCount(twitter,trend).map(xyz => xyz.floatValue())
      val sleepTime = 10000
      Thread.sleep(sleepTime)
      val numberOfDays = 10
      count.value.get.get / numberOfDays
    }

    /*
            println(s"total tweets since 10 days is ${tweets.length} ")
            print(s"avg = ${result.getTweets.size().toFloat/10}")
    */

    /*depricated
    val totalTweets: Int = 100
    val paging: Paging = new Paging(1,totalTweets)
    val userTweets = twitter.getUserTimeline(paging)
    userTweets.forEach(x => print(s"${x.getUser.getScreenName} : ${x.getId} : ${x.getText}"))
*/


  }




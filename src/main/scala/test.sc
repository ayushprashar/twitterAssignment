
/*
import twitter4j.{Query, QueryResult, Status, TwitterFactory}
import twitter4j.conf.ConfigurationBuilder
import scala.collection.JavaConverters._


val builder = new ConfigurationBuilder
builder.setDebugEnabled(true)
  .setOAuthConsumerKey("id9H9aV9Qcx1KD9bqV5CQnfUO")
  .setOAuthConsumerSecret("e0K15rYqNVQCMt9gJNsJ8HeiyfAekokikfu7XSNii4dRrPkoID")
  .setOAuthAccessToken("958655174049869824-53T6iqUxr5ubLhS9MWlwR76Z8NIRwJp")
  .setOAuthAccessTokenSecret("F1TR3n4H5yajlrANeePwn0ZkDBAwT2lM5h8rJ0yxpQuZ7")
val factory = new TwitterFactory(builder.build)
val twitter = factory.getInstance




val queryTrend: String = "#scala"
val query: Query = new Query(queryTrend)
query.since("2017-12-12")
val result:QueryResult = twitter.search(query)
val tweets= result.getTweets.asScala.toList
tweets.map(x => s"${x.getText} \n")*/

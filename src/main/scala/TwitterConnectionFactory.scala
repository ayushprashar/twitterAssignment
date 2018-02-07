import twitter4j._
import twitter4j.conf.ConfigurationBuilder
object TwitterConnectionFactory {

  def getInstance(consumerKey: String,consumerSecret: String,accessToken: String,accessTokenSecret: String): Twitter = {

    val builder = new ConfigurationBuilder
    builder.setDebugEnabled(true)
      .setOAuthConsumerKey(consumerKey)
      .setOAuthConsumerSecret(consumerSecret)
      .setOAuthAccessToken(accessToken)
      .setOAuthAccessTokenSecret(accessTokenSecret)
    val factory = new TwitterFactory(builder.build)
    factory.getInstance
  }
}

package q2io.chapter01.exercise

import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration.MILLISECONDS
import q2io.chapter01.MyIO

object Timing {

  def time[A](action: MyIO[A]): MyIO[(FiniteDuration, A)] = {
    for {
      t0 <- MyIO(() => System.currentTimeMillis)
      a <- action
      t1 <- MyIO(() => System.currentTimeMillis)
      r <- MyIO(() => (FiniteDuration(t1 - t0, MILLISECONDS), a))
    } yield r
  }

  def timedHello(s: => String): MyIO[(FiniteDuration, Unit)] =
    time(MyIO.putStr(s"$s from the timmer"))
}

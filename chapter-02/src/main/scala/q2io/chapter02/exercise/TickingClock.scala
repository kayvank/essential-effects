package q2io.chapter02.exercise

import cats.effect._
import cats.implicits._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext

object TickingClock {

  // note using the applicative, causes sporadic stackoverflow
  implicit val timer: Timer[IO] = IO.timer(ExecutionContext.global)
  def repeat(io: IO[Unit]): IO[Nothing] =
    io >> IO.sleep(1.second) >> repeat(io)
}

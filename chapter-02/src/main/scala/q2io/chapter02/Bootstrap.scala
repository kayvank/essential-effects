package q2io.chapter02

import cats.effect.{IOApp, ExitCode, IO}
import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration.SECONDS
import exercise.TickingClock

object Bootstrap extends IOApp {

  val helloWorld: IO[Unit] =
    IO(println(s"Hello World! ${System.currentTimeMillis}"))

  override def run(args: List[String]): IO[ExitCode] = {
    val helloWithTimer = for {
      _ <- helloWorld
      _thread <- TickingClock.repeat(helloWorld).start
      _ <- IO.delay(
        println(s"the rest of my app. epoch: ${System.currentTimeMillis}")
      )
      _ <- _thread.join
    } yield ()
    helloWithTimer.as(ExitCode.Success)
  }
}

package q2io.chapter01

import q2io.chapter01.MyIO
import q2io.chapter01.exercise.Timing

object Bootstrap extends App {
  val now: String = s"${System.currentTimeMillis}"
  val hello: MyIO[Unit] = MyIO.putStr(s"hello world @ epoch: $now")
  val hello2 = MyIO(() => println(s"hello world @ epoch: $now"))
  val hello3 = for {
    _ <- MyIO.putStr("hello world @ epoch: ")
    _ <- MyIO.putStr(now)
  } yield ()

  hello.unsafeRun()
  hello2.unsafeRun()
  hello3.unsafeRun()

  Timing.timedHello(s"hello world @ epoch: $now").unsafeRun() match {
    case (duration, _) => println(s" hello took $duration")
  }
}

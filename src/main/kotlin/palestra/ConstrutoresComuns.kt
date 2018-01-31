package palestra

import io.reactivex.Observable

/**
 * Created by fernando on 30/01/2018.
 */

fun main(args: Array<String>) {

    example(of = "just") {


        val observable = Observable.just("A")

        observable
                .subscribe { value ->
                    println(value)
                }

    }


    example(of = "just com mais argumentos") {

        val observable = Observable.just("A", "B")

        observable
                .subscribe { value ->
                    println(value)
                }

    }

    example(of = "create") {

        val observable = Observable.create<String> { observer ->

            observer.onNext("D")
            observer.onNext("E")
            observer.onNext("F")

            observer.onComplete()

        }

        observable
                .subscribe( { value ->
                    println(value)
                },
                        {
                            println("errou")
                        }, {
                    println("completou")
                })

    }

    example(of = "fromArray") {

        val observable = Observable.fromArray(1, 2, 3)

        observable
                .subscribe { value ->
                    println(value)
                }
    }

    example(of = "fromMutable") {

        val observable = Observable.fromIterable( mutableListOf("A", "B", "C"))

        observable
                .subscribe { value ->
                    println(value)
                }
    }
}
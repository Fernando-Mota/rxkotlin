package palestra

import io.reactivex.Observable
import java.util.*

/**
 * Created by fernando on 30/01/2018.
 */


fun main(args: Array<String>) {


    example(of = "range") {

        val observable = Observable.range(2, 5)

        observable
                .subscribe { value ->
                    println(value)
                }
    }

    example(of = "never") {

        val observable = Observable.never<Unit>()

        observable
                .subscribe(
                        {value -> println(value)},
                        {error -> println(error.stackTrace)},
                        {println("Completou!")},
                        {println("Disposou!")}
                )
    }

    example(of = "empty") {

        val observable = Observable.empty<Unit>()

        observable
                .subscribe(
                        {value -> println(value)},
                        {error -> println(error.stackTrace)},
                        {println("Completou!")},
                        {println("Disposou!")}
                )
    }
}
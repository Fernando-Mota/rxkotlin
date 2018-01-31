package palestra

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by fernando on 30/01/2018.
 */

enum class Possibilidades {

    deuBom,

    deuRuim,

    soCompleta

}

fun main(args: Array<String>) {

    example(of = "single") {



        val single = Single.create<String> { single ->

            val success = true

            if (success) {
                single.onSuccess("Deu bom")
            } else {
                single.onError(Throwable("deu ruim"))
            }

        }

        single
                .subscribe({value ->
                    println(value)
                },
                        { error ->
                            println(error.message)
                        })

    }

    example(of = "completable") {

        val completable = Completable.create { completable ->

            val success = true

            if (success) {
                completable.onComplete()
            } else {
                completable.onError(Throwable("Deu ruim"))
            }
        }

        completable
                .subscribe({
                    println("deu bom")
                },
                        { error ->
                            println(error.message)
                        })
    }

    example(of = "maybe") {

        val maybe = Maybe.create<String> { maybe ->

            val status = Possibilidades.soCompleta

            when (status) {
                Possibilidades.deuRuim -> maybe.onError(Throwable("Deu ruim!"))
                Possibilidades.deuBom -> maybe.onSuccess("Deu bom!")
                Possibilidades.soCompleta -> maybe.onComplete()
            }
        }

        maybe
                .subscribe({ value ->
                    println(value)
                },
                        { error ->
                            println(error.message)
                        },
                        {
                            println("Completou!")
                        })
    }
}
(ns lab4cloj
  (:use [clojure.data])
  (:import [java.util List Set]))


(def blams (map vector '("Inese" "Vasja" "Petja" "Natasha" "Anja" "Lauris" "Sandra" "Krišjanis") '(10 8 4 7 10 6 8 9))) ;map vector studentu saraksts

;(println blams)
;(println (first blams))
;(println (get (first blams) 0))
;(println (get (first blams) 1))
;(println (take-last 1 (get (first blams) 0)))
;(println (last (get (first blams) 0)))
;(println (+ (get (first blams) 1) (get (first (rest blams)) 1) (get (first (rest blams)) 1)))

;(println (take 5 (iterate + (get (first blams) 1))))        ;try recur i guess

;(println (get (take-last 1 (get (first blams) 0)) 1))
;(println (get (first blams) 0))

;(def kopa 0)
;(def skaits 0)
;(if (= "e" (let [len (count (get (first blams) 0))] (subs (get (first blams) 0) (- len 1)))) (println "true")(println "false")) ;atrast studentus kuru vardi beidazs ar ...

(defn vid-a-stud [blams-rec kopa skaits]                     ;funkcija ar recur
  (do
    ;(println (str "test: " (count blams-rec)))
    ;(println blams-rec)
    ;(println skaits)
    ;(println kopa)
    (if (= 0 (count blams-rec))
      (if (> skaits 0)
        (println (str "Videja atzime: " (double (/ kopa skaits))))
        (println "Videja atzime nav!")
        )
      ) ;rezultats pec pedejas iteracijas

    (if (< 0 (count blams-rec))                             ;turpina ciklu kamer map vector nav tukss
      (do
        (if (= "a" (let [len (count (get (first blams-rec) 0))] (subs (get (first blams-rec) 0) (- len 1))))  ;atrast studentus kuru vardi beidazs ar "a"
          (recur                                            ;ja true, tad beidzas ar "a" un recur ar jaunam vertibam
            (rest blams-rec)
            (+ kopa (get (first blams-rec) 1))              ;kopa += atzime
            (inc skaits)                                    ;skaits++
            );recur
          (recur                                            ;ja false, tad recur, saglabajot vertibas
            (rest blams-rec)
            kopa
            skaits
            );recur
          );if... "a"
        ;(recur
        ;(rest blams-rec)
        ;(+ kopa (get (first blams-rec) 1))
        ;(inc skaits)
        ;)
        )
      )
    )
  )

(vid-a-stud blams 0 0)                                      ;izsauc funkciju ar map vector un sakuma vertibam 0

;(println (count blams))
;(println (reduce + (take 5 (iterate + (get (first blams) 1)))))
;(def restblams (rest blams))
;(println restblams)
;(def restblams (rest restblams))
;(println restblams)
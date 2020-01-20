(ns lab5cloj
  (:use [clojure.data]))

(def blams (map vector '("Inese" "Vasja" "Petja" "Natasha" "Anja" "Lauris" "Sandra" "Krišjanis") '(10 8 4 7 10 6 8 9))) ;map vector studentu saraksts

(defn vid-a-stud [blams-rec kopa skaits]                     ;funkcija ar recur
    (if (< 0 (count blams-rec))                             ;turpina ciklu kamer map vector nav tukss
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
        (if (> skaits 0) (double (/ kopa skaits)) nil)                            ;atgriez rezultatu
      )
  )
(println (str "Videja atzime: " (vid-a-stud blams 0 0)))                                  ;izsauc funkciju ar map vector un sakuma vertibam 0

#!/bin/bash lein exec

(defn euler1 [] ;233168
  (let [first-999 (take 999 (iterate inc 1))
         mod-filter #(or (= 0 (mod % 3))
                         (= 0 (mod % 5)))]
    (apply + (filter mod-filter first-999))))

(defn euler1b [] 
  (let [ naturals (iterate inc 1)
         filter0 #(< % 1000)
         filter1 #(or (= 0 (mod % 3))
                      (= 0 (mod % 5)))]
    (->> naturals
        (filter filter0)
        (take 1000)
        (filter filter1))))

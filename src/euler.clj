(ns euler
  (:import [java.util BitSet])
  (:require [clojure.math.numeric-tower :as m]))

(defn problem001 
  "If we list all the natural numbers below 10 that are multiples of 3 or 5, 
   we get 3, 5, 6 and 9. The sum of these multiples is 23.
   Find the sum of all the multiples of 3 or 5 below 1000."
  []
  (let [ naturals (iterate inc 0)
         lt1000 #(< % 1000)
         mod35 #(or (== 0 (mod % 3))
                    (== 0 (mod % 5)))]
    (->> naturals
        (take-while lt1000)
        (filter mod35)
        (reduce +))))

(def fibonaccni 
  "A lazy list of Fibonaccni numbers"
  (map first 
    (iterate 
      (fn [[a b]] [b (+ a b)])
      [1 1])))

(defn problem002 
  "By considering the terms in the Fibonacci sequence whose values do not exceed 
   four million, find the sum of the even-valued terms."
  [] 
    (->> fibonaccni
        (take-while #(< % 4000000))
        (filter even?)
        (reduce +)))

; http://diditwith.net/2009/01/20/YAPESProblemSevenPart2.aspx
(def primes 
  "A lazy list of primes"
  (map first 
    (iterate 

      (fn [[p pset]] 
        (loop [candidate (inc p)]
          (if (nil? (some #(== 0 (mod candidate %)) pset))
            [candidate (conj pset candidate)]
            (recur (inc candidate)))))

      [2 #{2}])))

(defn problem003 
  "What is the largest prime factor of the number 600851475143?"
  [] 
    (->> primes
        (take-while #(< % (m/sqrt 600851475143)))))



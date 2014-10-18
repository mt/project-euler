(ns euler.problem002
  (:import [java.util BitSet])
  (:require [clojure.math.numeric-tower :as m]))

(def fibonaccni 
  "A lazy list of Fibonaccni numbers"
  (map first 
    (iterate 
      (fn [[a b]] [b (+ a b)])
      [1 1])))

(defn solve
  "By considering the terms in the Fibonacci sequence whose values do not exceed 
   four million, find the sum of the even-valued terms."
  [] 
    (->> fibonaccni
        (take-while #(< % 4000000))
        (filter even?)
        (reduce +)))

(defn -main [] (println (solve)))

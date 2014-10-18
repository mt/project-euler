(ns euler.problem003
  (:require [clojure.math.numeric-tower :as m]))

(defn not-multiple-of?
  [factors n]
  (let 
    [is-multiple #(== 0 (mod n %))
     sqrt-n (m/sqrt n)
     factors-lt-sqrt (filter #(<= % sqrt-n) factors)]
    (nil? (some is-multiple factors))))

(def primes 
  "A lazy list of primes"
  (map first 
    (iterate 
      (fn [[p pset]]
        (loop [candidate (inc p)]
          (if (not-multiple-of? pset candidate)
            [candidate (conj pset candidate)]
            (recur (inc candidate)))))
      [2 (sorted-set 2)])))

(defn smallest-prime-factor [n]
  (if (<= n 1) 1
    (loop [factors primes]
      (let [f0 (first factors)
            fs (rest factors)] 
        (if (== 0 (mod n f0)) 
          f0 
          (recur fs))))))


(defn prime-factors [n] 
  (let [stream (iterate (fn [[_ m]] 
                          (let [p (smallest-prime-factor m)]
                            (if (== p 1) 
                              [1 1]
                              [p (quot m p)])))
                [nil n])
        neq1 #(not= 1 %)]
    (->> stream
      (drop 1)
      (map first)
      (take-while neq1))))

(defn solve
  "What is the largest prime factor of the number 600851475143?"
  [] 
  (->> 600851475143 
    (euler.problem003/prime-factors) 
    (reduce max)))


(defn -main [] (println (solve)))


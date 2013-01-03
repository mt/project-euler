(ns euler)

(defn problem001 
  "If we list all the natural numbers below 10 that are multiples of 3 or 5, 
   we get 3, 5, 6 and 9. The sum of these multiples is 23.
   Find the sum of all the multiples of 3 or 5 below 1000."
  []
  (let [ naturals (iterate inc 0)
         mod35 #(or (== 0 (mod % 3))
                    (== 0 (mod % 5)))]
    (->> naturals
        (take 1000)
        (filter mod35)
        (apply +))))


(defn problem002 
  "By considering the terms in the Fibonacci sequence whose values do not exceed 
   four million, find the sum of the even-valued terms."
  [] 
  (loop [acc 0 f0 1 f1 2]
    (cond 
      (> f0 4000000) acc
      (== 0 (mod f0 2)) (recur (+ f0 acc) f1 (+ f1 f0))
      :else (recur acc f1 (+ f1 f0)))))

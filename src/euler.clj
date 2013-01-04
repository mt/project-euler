(ns euler)

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

(defn problem002 
  "By considering the terms in the Fibonacci sequence whose values do not exceed 
   four million, find the sum of the even-valued terms."
  [] 
  (let [ fgen (fn [[a b]] [b (+ a b)])
         fibs (map first (iterate fgen [1 1]))
         lt4million #(< % 4000000)]
    (->> fibs
        (take-while lt4million)
        (filter even?)
        (reduce +))))

(defn problem003 
  "What is the largest prime factor of the number 600851475143?"
  [] 
  (let [ fgen (fn [[a b]] [b (+ a b)])
         fibs (map first (iterate fgen [1 1]))
         lt4million #(< % 4000000)]
    (->> fibs
        (take-while lt4million)
        (filter even?)
        (reduce +))))

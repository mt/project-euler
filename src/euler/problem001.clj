(ns euler.problem001)

(defn solve
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

(defn -main [] (println (solve)))

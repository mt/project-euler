(ns euler)

(defn problem001 [] 
  (let [ naturals (iterate inc 0)
         mod35 #(or (= 0 (mod % 3))
                      (= 0 (mod % 5)))]
    (->> naturals
        (take 1000)
        (filter mod35)
        (apply +))))

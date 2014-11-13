(ns euler.problem004)

(defn palindrome? [n]
  (let [s (str n)
        l (count s)]
    (if (= l 1)
      true
      (let [m (quot l 2)
            head (map #(.charAt s %) (range 0 m) ) 
            tail (map #(.charAt s %) (range (dec l) (dec m) -1))]
        (->> (map vector head tail)
          (every? #(= (% 0) (% 1))))))))

(def products 
  (for [i (range 100 1000) j (range i 1000)] (* i j)))

(defn solve
  "A palindromic number reads the same both ways. 
   The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
   Find the largest palindrome made from the product of two 3-digit numbers."
  [] 
  (->> products
    (filter palindrome?)
    (reduce max)))

(defn -main [] (println (solve)))


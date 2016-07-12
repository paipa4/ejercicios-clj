(ns raindrops)

(defn d-value [number]
  (loop [div 2]
    (if (= 0 (mod number div))
      div
      (recur (inc div)))))

(defn of [number]
  (loop [n number
         result []]
    (if (= 1 n)
       result
      (let [div (d-value n)]
        (recur (/ n div)
               (conj result div))))))

(def numbs
  {3 "Pling"
   5 "Plang"
   7 "Plong"})

(defn convert [number]
  (let [coll (of number)
        n-coll (distinct (filterv numbs coll))]
    (if (empty? n-coll)
      (str number)
      (reduce str (map numbs n-coll)))))


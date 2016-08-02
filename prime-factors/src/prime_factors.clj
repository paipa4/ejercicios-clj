(ns prime-factors)

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

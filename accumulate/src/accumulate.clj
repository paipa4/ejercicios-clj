(ns accumulate)

(defn accumulate [function collection]
  (let [fun function]
  (loop [coll collection
         result [] ]
    (if (empty? coll)
      result
      (recur (rest coll)
             (conj result (fun (first coll))))))))

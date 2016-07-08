(ns roman-numerals
  (:require [clojure.string :as string]))


(def romans {1 "I"
             5 "V"
             10 "X"
             50 "L"
             100 "C"
             500 "D"
             1000 "M"})

(defn rom [n mult]
  (cond
    (< n 1) ""
    (< n 4) (str (romans mult)
                 (rom (- 1 n) mult))
    (< n 9) (str (rom (- 5 n) mult)
                 (romans (* mult 5))
                 (rom (- n 5) mult))
    :else (str (rom (- 10 n) mult)
               (romans (* mult 10)))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn to-roman [number]
  (reduce str
          (reverse (map-indexed #(rom (Integer. (str %2)) (exp 10 %1))
                                (reverse (str number))))))



(


















;; (def numbers  {1 "I", 2 "II", 3 "III", 4 "IV", 5 "V", 6 "VI", 7 "VII",
;;                8 "VIII", 9 "IX", 10 "X",20 "XX" 40 "XL", 50 "L", 60 "LX"
;;                70 "LXX" 90 "XC", 100 "C", 400 "CD", 500 "D", 900 "CM", 1000 "M"})

;; (defn miles [lista]
;;   (let [mil (first lista)
;;         div (first (map #(Integer. (str %)) (str mil)))]
;;     (repeat div 1000)))

;; (defn dec-list [number]
;;   (loop [n-seq (reverse (map #(Integer. (str %)) (str number)))
;;          n 1
;;          resultado '()]
;;     (if (empty? n-seq)
;;       resultado
;;       (recur (nthrest n-seq 1)
;;              (* n 10)
;;              (conj resultado (* n (first n-seq)))))))

;; (defn convert [lista]
;;   (if (= 4 (count lista))
;;     (let [n-list (flatten (cons (miles lista)(rest lista)))]
;;       (map numbers n-list))
;;     (map numbers lista)))

;; (defn numerals [number]
;;   (string/join (convert (dec-list number))))


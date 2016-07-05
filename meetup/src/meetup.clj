(ns meetup
  (:require [clojure.string :as string]))


(defn abs [n] (max n (- n)))

(defn teenth? [n]
(if (= n 16)
    true
  (< (abs (- n 16)) 4)))

(defn search
  [pred coll]
  (.indexOf (map pred coll) true))


(defn teenth
"Find the closest day to 16"
  [coll]
  (let [index (search teenth? coll)]
  (nth coll index)))

(defn leap-year?
  "Defines when is a leap year"
  [year]
  (if (zero? (mod year 100))
    (zero? (mod year 400))
    (zero? (mod year 4))))

(defn first-year-day [year]
  ({2013 3} year))

(defn occurrences-on
"Gives a colection of days"
  [year month first-y-day day]
  (let [days-in-months [31
                        (if (leap-year? year) 29 28)
                        31 30 31 30 31 31 30 31 30 31]
        total-days (nth days-in-months (dec month))
        calc-days #(range (if (> % 7) (- % 7) %)
                          (inc total-days)
                          7)
        first-day (mod (+ (dec first-y-day)
                          (apply + (take (dec month)
                                         days-in-months)))
                       7)
        days [:sunday :monday :tuesday :wednesday :thursday :friday :saturday]
        day-n (inc (.indexOf days day))]

    (calc-days (+ (- 7 first-day)
                  day-n))))

(defn meetup
  "Returns a date"
  [month year day func]
  (let [days (occurrences-on year month (first-year-day year)
                             day)
        date (case func
               :teenth (teenth days)
               :first (first days)
               :last (last days)
               :second (nth days 1)
               :third (nth days 2)
               :fourth (nth days 3))]
    (vector year month date)))

(ns binary-search-tree)

(defn singleton [root]
  {:root root})

(def value :root)
(def left :left)
(def right :right)

(defn insert [node subtree]
  (if (< (:root subtree) node)
    (if (:right subtree)
      (assoc subtree :right (insert node (:right subtree)))
      (assoc subtree :right (singleton node)))
    (if (:left subtree)
      (assoc subtree :left (insert node (:left subtree)))
      (assoc subtree :left (singleton node)))))


(defn from-list [collection]
  (reduce #(insert %2 %1)
          (singleton (first collection))
          (rest collection)))

(defn to-list [subtree]
  (if subtree
    (concat (to-list (left subtree))
            [(value subtree)]
            (to-list (right subtree)))[]))

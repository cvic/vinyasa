(ns vinyasa.core
  (:require [vinyasa.intern :refer [intern]])
  (:refer-clojure :exclude [intern]))

(defn enable [args]
  (let [st (set (map str args))]
    (when (get st "lein")
      (intern lein vinyasa.lein/lein :require))
    (when (get st "pull")
      (intern pull vinyasa.pull/pull :require))
    (when (get st "inspect")
      (intern inspect vinyasa.inspect/inspect))
    (when (get st "pprint")
      (intern pprint clojure.pprint/pprint :require))
    (when (get st "refresh")
      (intern refresh clojure.tools.namespace.repl/refresh :require))
    (when (get st "spyscope")
      (require 'spyscope.core))
    (when (get st "ansi")
      (intern color io.aviso.ansi/inverse :require))
    (when (get st "binary")
      (intern write-binary io.aviso.binary/write-binary :require))
    (when (get st "stacktrace")
      (require 'vinyasa.stacktrace))
    (when (get st "repl")
      (intern apropos clojure.repl/apropos :require)
      (intern dir  clojure.repl/dir)
      (intern doc  clojure.repl/doc)
      (intern find-doc clojure.repl/find-doc)
      (intern root-cause clojure.repl/root-cause)
      (intern source clojure.repl/source))))

(require '[io.aviso.ansi :as v])
(println (str "oeuoeu"  ( (v/blue (v/italic  "oeuoeu")))))
(require '[io.aviso.exception :as x])
(x/write-exception (ex-info "Oeuoeu" {:a 1}))

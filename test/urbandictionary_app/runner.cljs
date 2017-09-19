(ns urbandictionary-app.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            urbandictionary-app.handlers-test
            urbandictionary-app.subs-test))

(doo-tests 'urbandictionary-app.handlers-test
           'urbandictionary-app.subs-test)

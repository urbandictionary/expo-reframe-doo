(ns urbandictionary-app.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [urbandictionary-app.hello-test]))

(doo-tests 'urbandictionary-app.hello-test)

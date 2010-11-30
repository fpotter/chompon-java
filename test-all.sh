#!/bin/sh

./chompon.sh --get-deals --pid 12 --auth 26a4171b3c38b868
./chompon.sh --get-deals --pid 12 --auth 26a4171b3c38b868 --did 987
./chompon.sh --get-deals-by-zip --pid 12 --auth 26a4171b3c38b868 --zip 94303
./chompon.sh --get-deal-for-user --pid 12 --auth 26a4171b3c38b868 --uid 25 --did 987
./chompon.sh --get-user-info --pid 12 --auth 26a4171b3c38b868 --uid 8
./chompon.sh --get-user-info --pid 12 --auth 26a4171b3c38b868 --email ruven@chompon.com
./chompon.sh --get-user-from-email --pid 12 --auth 26a4171b3c38b868 --email ruven@chompon.com
./chompon.sh --get-coupon-info --pid 12 --auth 26a4171b3c38b868 --cid 094614084
./chompon.sh --create-user --pid 12 --auth 26a4171b3c38b868 --fname Fred --lname Potter --zip 94118 --email fpotter@gmail.com --password chompon --gender male --birthday 04-01-1982
./chompon.sh --issue-coupons --pid 12 --auth 26a4171b3c38b868 --did 987 --uid 8
./chompon.sh --create-user-email-zip --pid 12 --auth 26a4171b3c38b868 --email fpotter@gmail.com --zip 94118
./chompon.sh --get-store-links --pid 12 --auth 26a4171b3c38b868 --sid 3
./chompon.sh --refund-coupon --pid 12 --auth 26a4171b3c38b868 --cd 625846413
./chompon.sh --get-deal-seo --pid 12 --auth 26a4171b3c38b868 --did 987
./chompon.sh --get-rss-feed --pid 12 --auth 26a4171b3c38b868 --zip 94306
./chompon.sh --add-credit --pid 12 --auth 26a4171b3c38b868 --uid 6 --amount 12.75

# currently broken as the type=json argument isn't being respected
#./chompon.sh --get-credit --pid 12 --auth 26a4171b3c38b868 --uid 6
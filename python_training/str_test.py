import json

__author__ = 'yrd'

order_insert = """INSERT INTO eleme_order (id, restaurant_id, restaurant_name, rst_owner_id, user_id, user_name, detail_json, total, deliver_fee, is_online_paid, settled_at, address, phone, restaurant_number, ip, description, unique_id, auto_memo, order_mode, status_code, delivery_status, refund_status, is_book, deliver_time, category_id, come_from, entry_id, time_spent, coupon_id, created_at, invoice, attribute_json, geohash, phone_rating, source, active_at, updated_at) VALUES ({order_id}, 123, '重庆小炒盖浇饭', 14529911, 456, 'yTjefsoZYNQD', "", 20, 0, 1, NULL, '车站西', '18504710655,', 0, '111.127.58.11', '', '100023983024902189', '', 9, -5, 0, 0, 0, '1970-01-01 08:00:00', 1, 4, 0, 0, 0, '2015-09-18 14:17:16', '', '', -616304638120742553, 0, '', '2015-09-18 14:17:16.247680', '2015-09-18 14:17:16.247699')"""

class ElemeOrderFake(object):
    order_template = "insert into eleme_order values ( {order_id}, 123 , {order_details})"
    order_details = {
        "abandoned_extra": [],
        "phone": "18504710655",
    }

    def __init__(self, order_id):
        self.order_id = order_id

    def __str__(self):
        return ElemeOrderFake.order_template.format(
            order_id=self.order_id,
            order_details=json.dumps(ElemeOrderFake.order_details)
        )


        # a = ElemeOrderFake(id1)
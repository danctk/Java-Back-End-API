INSERT INTO
    public.tasks(id, title, description, due, done)
VALUES
    (101,'pack bags', 'pack bags for trip', '01/01/2023', false),
    (102,'lunch appointment', 'meet client for lunch', '01/01/2023', false),
    (103,'drop car at shop', 'bring car into shop for repairs', '01/01/2023', false),
    (104, 'hit the gym', 'workout at the gym', '01/01/2023', false),
    (105, 'buy socks', 'get socks at store', '01/01/2023', false)
ON CONFLICT ON CONSTRAINT tasks_pkey
DO NOTHING;

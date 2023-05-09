CREATE database wallet;
CREATE user  wallet with superuser connection limit -1 password  'P@ssword';
grant all privileges  on database wallet to wallet;
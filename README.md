# vu-simplifed-blockchain

## Blokų grandinės simuliacija

### VU ISI Blokų grandinų techonologijų atsiskaitymo darbas

#### Ką programa vykdo?
- Prikuria atsitiktinių vartotojų
- Sukuria random transakcijų pool'ą
- Kasami blokai iki tol, kol transakcijų pool'e yra >= bloko transakcijų kiekį
- Išspausdinami kiekvieno iškasto bloko laiko žymė ir hash'as, pvz:
```
1) 2020.11.12 20:06:37 0003893c8b92c3dfdbbdc1f4df0f2f1f357a49d79288b6f1fd5dc17512df3144
2) 2020.11.12 20:06:43 000868f72ec2ed02cdcc721fe3581972295dc7fdf3693275045769383e51551a
3) 2020.11.12 20:06:47 000bac2cb53370275469ee131f28542132f0ac7d95fdb8e2ef7341b34aa08381
4) 2020.11.12 20:07:11 0005dab9a96aa6f753508651eed14ff632c0ee5d1930f330480e135361502645
5) 2020.11.12 20:07:17 000fa4ad126d289b98fc6741bb4efc5641be51dba68d33dd3de8ba9061705da3
```

#### Naudojimas

Programa parašyta _Java_ programavimo kalba, todėl projektą galima paleisti su _java_ komanda komandinėje eilutėje arba per bet kokį Java palaikantį _IDE_.

```src/blockchain/constants/Constants``` faile yra konstantos, kurias galima keisti pagal poreikį.

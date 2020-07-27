create table stock(noodle number(5) not null, 
                                yuksu number(5) not null, 
                                gomung_mu number(5) not null, 
                                gomung_egg number(5) not null, 
                                gomung_goggi number(5) not null, 
                                gomung_oi number(5) not null, 
                                hae number(5) not null,
                                goggi number(5) not null, 
                                mandoo number(5) not null);
                                
create table benefit(totalMulBenefit number(10) not null,
			totalBibimBenefit number(10) not null,
			totalHaeBenefit number(10) not null,
			mandooBenefit number(10) not null,
			goggiBenefit number(10) not null,
			totalBenefit number(10) not null);

insert into stock values (300, 100, 300, 300, 300, 300, 100, 200, 200);
insert into benefit values (0,0,0,0,0,0);
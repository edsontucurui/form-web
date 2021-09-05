insert 
into 
pessoas (nome_completo, telefone, dt_nascimento, email, sexo, tecnologia , escolaridade )
values('Edson','999999','13/09/2000','','m','','');

select * 
from pessoas p 

update pessoas p
set email = 'edson.p.silva@df.estudante.senai.br'
where p.nome_completo = 'Edson'


select nome_completo, email
from pessoas 

delete from pessoas
where id in ('6','7','5');
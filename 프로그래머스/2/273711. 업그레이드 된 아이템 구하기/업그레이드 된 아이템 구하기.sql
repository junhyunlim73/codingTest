-- 코드를 작성해주세요
select t.ITEM_ID,  (select 	ITEM_NAME
        from ITEM_INFO
        where ITEM_ID = t.ITEM_ID) as "	ITEM_NAME", (select rarity
        from ITEM_INFO
        where ITEM_ID = t.ITEM_ID) as "RARITY"
from ITEM_INFO i
join ITEM_TREE t
on i.ITEM_ID = t.PARENT_ITEM_ID
where i.RARITY = 'RARE'
order by t.ITEM_ID desc
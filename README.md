## association mapping
##### `unidirectional-association`: 단방향 연관관계

### one-to-many 
##### `one-to-many-unidirectional`: 일대다 단방향[1:N] -> 단점 존재(대안: 다대일 양방향 매핑을 활용) 

### many-to-many
##### `many-to-many-unidirectional`: 다대다 단방향 -> 한계 존재
##### `many-to-many-bidirectional`: 다대다 양방향 -> 한계 존재
##### `alternative-many-to-many`: 다대다 양방향 한계 극복

---

## value object
##### `value-object-collection`: 값 타입 컬렉션 -> 제약사항 존재
##### `alternative-value-object-collection`: 값 타입 컬렉션 대안(일대다 관계 활용)
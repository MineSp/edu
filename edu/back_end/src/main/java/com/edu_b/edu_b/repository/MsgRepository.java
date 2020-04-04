package com.edu_b.edu_b.repository;

        import com.edu_b.edu_b.entity.Msg;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgRepository extends JpaRepository<Msg, Integer> {
}

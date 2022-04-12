package com.gamebroadcast.forum.interaction.comment.models;

import javax.persistence.*;

import com.gamebroadcast.forum.content.content.Content;
import com.gamebroadcast.forum.user.schemas.AppUser;
import com.gamebroadcast.forum.utils.SessionUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @SequenceGenerator(name = "comment_sequence", sequenceName = "comment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AppUser author;

    @Column(length = 2048)
    private String comment;

    public void publish() {
        author = SessionUtils.getUserFromSession();
    }

    public boolean ownedBy(AppUser user) {
        return this.author.getId().equals(user.getId());
    }

    public boolean ownedBy(Long id) {
        return this.author.getId().equals(id);
    }
}

export interface RestaurantDto {
  id: number;
  nom: string;
  commentaires?: CommentaireDto[];
  coverUrl?: string;
}

export interface CommentaireDto {
  id: number;
  nom: string
}

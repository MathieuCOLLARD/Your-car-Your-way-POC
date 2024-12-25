export interface Message {
    id?: number; // Identifiant unique du message
    sender: string; // Expéditeur du message
    content: string; // Contenu du message
    timestamp?: string; // Date et heure de création du message (format ISO 8601)
}
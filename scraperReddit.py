import praw
import pandas as pd
from datetime import datetime

# Initialize Reddit API
reddit = praw.Reddit(
    client_id='_ir_IyJ2SOKADsT0q0Pt-g',
    client_secret='jpzuux0Os-EFykhZp6M-WNx-Y3dODw',
    user_agent='Scraper'
)

def fetch_posts(subreddit_name, limit=10):
    try:
        subreddit = reddit.subreddit(subreddit_name)
        posts = []
        for submission in subreddit.hot(limit=limit):
            posts.append({
                'title': submission.title,
                'score': submission.score,
                'id': submission.id,
                'url': submission.url,
                'created_utc': submission.created_utc,
                'num_comments': submission.num_comments
            })
        return posts
    except Exception as e:
        print(f"Fehler beim Abrufen der Posts: {e}")
        return []

def save_to_csv_with_pandas(data, subreddit_name):
    try:
        date_str = datetime.now().strftime("%Y-%m-%d")
        filename = f"posts_{subreddit_name}_{date_str}.csv"
        df = pd.DataFrame(data)
        df.to_csv(filename, index=False, encoding='utf-8')
        print(f"Erfolgreich gespeichert in {filename}")
    except Exception as e:
        print(f"Fehler beim Speichern: {e}")

if __name__ == "__main__":
    subreddit_name = 'de'  # Hier das Subreddit angeben
    posts = fetch_posts(subreddit_name, limit=5)
    if posts:
        save_to_csv_with_pandas(posts, subreddit_name)
    else:
        print("Keine Posts gefunden oder Fehler beim Abrufen.")
